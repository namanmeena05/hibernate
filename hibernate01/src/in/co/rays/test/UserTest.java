package in.co.rays.test;

import in.co.rays.dto.UserDTO;
import in.co.rays.model.UserModel;

public class UserTest {
	
	public static void main(String[] args) {
		//testAdd();
		//testUpdte();
		//testSearch();
		testAuthenticate();
	}

	private static void testAuthenticate() {
		
		UserModel model = new UserModel();
	UserDTO dto =	model.authenticate("naman@gmail.com", "123");
		System.out.println(dto.getFirstName());
	}

	private static void testSearch() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("sachin");
		UserModel model = new UserModel();
		
		model.search(dto);
		System.out.println(dto.getFirstName());
		
	}

	private static void testUpdte() {
		UserDTO dto = new UserDTO();
		//dto.setId(2);
		dto.setFirstName("moseen");
		dto.setLastName("Khan");
		
		UserModel model  = new UserModel();
		model.update(dto);
		
	}

	private static void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("naman");
		dto.setLastName("meena");
		dto.setAddress("indore");
		dto.setLogin("namna@gmail.com");
		
		UserModel model = new UserModel();
		model.add(dto);
		
	}

}
