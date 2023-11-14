package in.co.rays.junit;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TestFail {
	
	@Test
	public void testAdd() throws Exception{
		UserDTO dto = new UserDTO();
		dto.setId(12);
		dto.setName("RAM");
		dto.setSalary(87777);
		
		UserModel.add(dto);
		dto = UserModel.findByPk(9);
		
		if(dto==null)
		{
			fail("Record is not added");
		}
		else {
			System.out.println("record is added");
		}
	}

}
