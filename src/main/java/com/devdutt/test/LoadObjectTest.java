package com.devdutt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.devdutt.entity.InsurancePolicy;
import com.devdutt.utils.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses = null;
		InsurancePolicy policy = null;
		// get the Session object
		ses = HibernateUtil.getSession();
		try {
			policy = ses.load(InsurancePolicy.class, 1115);
			if (policy != null) {
				System.out.println(policy.getPolicyId() + " " + policy.getPolicyName() + " "
						+ policy.getPolicyHolderName() + " " + policy.getTenure());
			} // if
			else {
				System.out.println("Record not found");
			} // else
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // catch
		catch (Exception e) {
			e.printStackTrace();
		} // catch

		// close the connections
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}// main
}
