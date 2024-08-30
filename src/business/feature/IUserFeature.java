package business.feature;

import business.entity.Users;

public interface IUserFeature extends Feature<Users, Integer>
{
	Users login(Users users);
}
