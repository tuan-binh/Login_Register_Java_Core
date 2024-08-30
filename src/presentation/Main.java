package presentation;

import business.constants.RoleName;
import business.entity.Users;
import business.feature.IUserFeature;
import business.feature.impl.UserFeatureImpl;
import presentation.admin.MenuAdmin;
import presentation.user.MenuUser;

import java.util.Scanner;

public class Main
{
	IUserFeature userFeature = new UserFeatureImpl();
	
	public static void main(String[] args)
	{
		Main main = new Main();
		
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃                           ┃                             ┃                          ┃                          ┃");
			System.out.println("┃        1. ĐĂNG NHẬP       ┃          2. ĐĂNG KÝ         ┃     3. QUÊN MẬT KHẨU     ┃        0. THOÁT          ┃");
			System.out.println("┃                           ┃                             ┃                          ┃                          ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println("Lựa chọn của bạn: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice)
			{
				case 1:
				{
					main.handleLogin(sc);
					break;
				}
				case 2:
				{
					main.handleRegister(sc);
					break;
				}
				case 3:
				{
					System.out.println("Chưa phát triển...");
					break;
				}
				case 4:
				{
					System.exit(0);
					break;
				}
				default:
					System.err.println("Vui lòng nhập lại từ 1 -> 4");
			}
		}
		while (true);
		
		
	}
	
	public void handleLogin(Scanner sc)
	{
		Users users = new Users();
		users.inputLogin(sc);
		users = userFeature.login(users);
		if (users == null)
		{
			System.err.println("Tên đăng nhập hoặc mật khẩu sai");
			return;
		}
		// check role để điều hướng sang menu mong muốn
		if (users.getRoleName().equals(RoleName.ADMIN))
		{
			// điều hướng sang menu admin
			MenuAdmin admin = new MenuAdmin();
			admin.menuAdmin(sc);
		}
		else
		{
			// điều hướng sang menu user
			MenuUser user = new MenuUser();
			user.menuUser(sc);
		}
	}
	
	public void handleRegister(Scanner sc)
	{
		Users users = new Users();
		users.inputRegister(sc);
		userFeature.addOrUpdate(users);
	}
}