package com.devdutt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.devdutt.entity.InsurancePolicy;
import com.devdutt.utils.HibernateUtil;

public class GetObjectTest {

	public static void main(String[] args) {

		Session ses = null;
		InsurancePolicy policy = null;
		// get Session class object
		ses = HibernateUtil.getSession();
		try {
			policy = ses.get(InsurancePolicy.class, 1112);
			// System.out.println(policy.getClass());
			if (policy != null) {
				System.out.println(policy.getPolicyId() + " " + policy.getPolicyName() + " "
						+ policy.getPolicyHolderName() + " " + policy.getTenure());
			} // if
			else {
				System.out.println("No Record Found");
			} // else
		} // try
		catch (HibernateException hb) {
			hb.printStackTrace();
		} // catch
		catch (Exception e) {
			e.printStackTrace();
		} // catch

		finally {
			// close the sessions
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		} // finally

	}
}
