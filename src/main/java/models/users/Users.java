package models.users;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Users {
    public Integer page;
    public Integer perPage;
    public Integer total;
    public Integer totalPages;
    public List<Datum> data = null;
}
