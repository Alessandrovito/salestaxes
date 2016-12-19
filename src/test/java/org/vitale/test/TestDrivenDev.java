package org.vitale.test;


import org.junit.Ignore;

public class TestDrivenDev {

	
	@Before
	public void setUp() throws Exception {
		dao = getContext().getBean(StatusUsersTypesDAO.class);

		dao2 = getContext().getBean(UserTypeDAO.class);

		dao3 = getContext().getBean(UsersDAO.class);

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void sendFaxToSend() {
		
	}
	
	@After
	public void tearDown() throws Exception {
		dao = null;
	}
}
