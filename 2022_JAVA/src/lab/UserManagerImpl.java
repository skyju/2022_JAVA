package lab;

import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements IUserManager {

	private List<User> userList = new ArrayList<User>();
	private static UserManagerImpl um;
	
	// 싱글톤
	private UserManagerImpl() {}
	public static UserManagerImpl getInstance() {
		if (um == null)
			um = new UserManagerImpl();
		return um;
	}

	public void add(User user) {
		userList.add(user);
	}

	public User[] getList() {
		User[] res = new User[userList.size()];
		return this.userList.toArray(res);
	}

	// 일반 사용자만 반환
	public User[] getUsers() {
		int cnt = 0;

		for (int i = 0; i < userList.size(); i++) {
			// 리스트안의 객체가 VipUser 클래스의 인스턴스인지 검사
			if (!(userList.get(i) instanceof VipUser))
				cnt++;
		}
		if (cnt == 0)
			return null;

		User[] res = new User[cnt];

		for (int i = 0, index = 0; i < userList.size(); i++) {
			// 리스트안의 객체가 VipUser 클래스의 인스턴스인지 검사
			if (!(userList.get(i) instanceof VipUser))
				res[index++] = userList.get(i);
		}
		return res;
	}

	// VipUser만 반환
	public VipUser[] getVipUsers() {

		int cnt = 0;

		for (int i = 0; i < userList.size(); i++) {
			// 리스트안의 객체가 VipUser 클래스의 인스턴스인지 검사
			if (userList.get(i) instanceof VipUser)
				cnt++;
		}

		if (cnt == 0)
			return null;

		VipUser[] res = new VipUser[cnt];

		for (int i = 0, index = 0; i < userList.size(); i++) {
			// 리스트안의 객체가 VipUser 클래스의 인스턴스인지 검사
			if (userList.get(i) instanceof VipUser)
				res[index++] = (VipUser) userList.get(i);
		}
		return res;
	}

	public User[] searchByName(String name) throws NameNotFoundException {

		int cnt = 0;

		for (int i = 0; i < userList.size(); i++) {
			// 주어진 이름을 포함하는 사용자인지 검사
			if (userList.get(i).getName().toLowerCase().contains(name.toLowerCase()))
				cnt++;
		}

		if (cnt == 0) {
			throw new NameNotFoundException(name);
		}

		User[] res = new User[cnt];

		for (int i = 0, index = 0; i < userList.size(); i++) {
			// 주어진 이름을 포함하는 사용자인지 검사
			if (userList.get(i).getName().toLowerCase().contains(name.toLowerCase()))
				res[index++] = userList.get(i);
		}
		return res;
	}

	// 사용자의 평균 나이 반환
	public double getAgeAvg() {
		int sum = 0;

		for (int i = 0; i < userList.size(); i++)
			sum += userList.get(i).getAge();
		return sum / userList.size();
	}

}
