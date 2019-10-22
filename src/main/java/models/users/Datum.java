package models.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Datum {
    public Integer id;
    public String email;
    public String firstName;
    public String lastName;
    public String avatar;
}
