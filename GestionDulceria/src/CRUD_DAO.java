
import java.util.List;

public interface CRUD_DAO {
	public List listar();
	public int add(Object[] o);
	public int actualizar(Object[] o);
	public void eliminar(int id);
}
