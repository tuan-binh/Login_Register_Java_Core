package business.entity;

import business.constants.RoleName;
import business.feature.impl.UserFeatureImpl;

import java.util.Scanner;

public class Users
{
	private int id;
	private String fullName;
	private String username;
	private String password;
	private String phone;
	private Boolean status = true;
	
	private RoleName roleName = RoleName.USER;
	
	public Users()
	{
	}
	
	public Users(int id, String fullName, String username, String password, String phone, Boolean status, RoleName roleName)
	{
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.roleName = roleName;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getFullName()
	{
		return fullName;
	}
	
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public Boolean getStatus()
	{
		return status;
	}
	
	public void setStatus(Boolean status)
	{
		this.status = status;
	}
	
	public RoleName getRoleName()
	{
		return roleName;
	}
	
	public void setRoleName(RoleName roleName)
	{
		this.roleName = roleName;
	}
	
	public void inputRegister(Scanner sc)
	{
		this.fullName = inputFullName(sc);
		this.username = inputUsername(sc);
		this.password = inputPassword(sc);
	}
	
	public void inputLogin(Scanner sc)
	{
		System.out.println("Nhập tên đăng nhập: ");
		this.username = sc.nextLine().trim();
		this.password = inputPassword(sc);
	}
	
	private String inputPassword(Scanner sc)
	{
		System.out.println("Nhập mật khẩu của bạn: ");
		do
		{
			String password = sc.nextLine();
			if (password.length() < 6)
			{
				System.err.println("Mật khẩu phải từ 6 ký tự trở lên");
			}
			else
			{
				return password;
			}
		}
		while (true);
	}
	
	private String inputUsername(Scanner sc)
	{
		// validate không được để trống, không trùng dữ liệu, không chưa ký tự đặc biệt
		System.out.println("Nhập tên đăng nhập: ");
		do
		{
			String username = sc.nextLine();
			if (username.isBlank())
			{
				System.err.println("Không được để trống");
			}
			else
			{
				if (username.matches("^[a-zA-Z0-9]+$"))
				{
					boolean isExist = UserFeatureImpl.usersList.stream().anyMatch(u -> u.getUsername().equals(username));
					if (isExist)
					{
						System.err.println("Tên đăng nhập đã trùng lặp");
					}
					else
					{
						return username;
					}
				}
			}
		}
		while (true);
	}
	
	private String inputFullName(Scanner sc)
	{
		System.out.println("Nhập vào tên của bạn: ");
		do
		{
			String fullName = sc.nextLine();
			if (fullName.isBlank())
			{
				System.err.println("Không được để trống");
			}
			else
			{
				return fullName;
			}
		}
		while (true);
	}
	
}
