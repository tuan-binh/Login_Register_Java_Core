package business.feature;

/**
 * @param <T> type of object handle ( kiểu dữ liệu đối tượng đang làm việc )
 * @param <E> type id in object handle (kiểu dữ liệu id trong đối tượng đang làm việc)
 */
public interface Feature<T, E>
{
	void addOrUpdate(T t);
	
	void remove(E id);
	
	int findIndexById(E id);
	
	E getNewId();
}
