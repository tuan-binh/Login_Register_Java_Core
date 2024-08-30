package business.feature.impl;

import business.entity.Users;
import business.feature.IUserFeature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class UserFeatureImpl implements IUserFeature
{
	public static List<Users> usersList = new ArrayList<>();
	
	@Override
	public void addOrUpdate(Users users)
	{
		int indexCheck = findIndexById(users.getId());
		if (indexCheck == -1)
		{
			// chức năng thêm mới
			users.setId(getNewId());
			usersList.add(users);
		}
		else
		{
			// chức năng cập nhật
			usersList.set(indexCheck, users);
		}
	}
	
	@Override
	public void remove(Integer id)
	{
		usersList.remove(findIndexById(id));
	}
	
	@Override
	public int findIndexById(Integer id)
	{
		return usersList.stream()
				  .map(Users::getId)
				  .toList()
				  .indexOf(id);
	}
	
	@Override
	public Integer getNewId()
	{
		Optional<Users> optionalUsers = usersList.stream().max(Comparator.comparingInt(Users::getId));
		if (optionalUsers.isPresent())
		{
			return optionalUsers.get().getId() + 1;
		}
		return 1;
	}
	
	@Override
	public Users login(Users users)
	{
		return usersList.stream()
				  .filter(u -> u.getUsername().equals(users.getUsername()) && u.getPassword().equals(users.getPassword()))
				  .findFirst()
				  .orElse(null);
	}
}
