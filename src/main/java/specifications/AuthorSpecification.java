package specifications;

import com.lurdharry.jpa.models.Author;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> hasAge(int age){
        return (
                root,
                criteriaQuery,
                criteriaBuilder
        ) ->{
            if (age < 0) {
                return null;
            }
            return criteriaBuilder.equal(root.get("age"),age);
        };
    }

    public static Specification<Author> firstNameContains(String firstName){
        return (
                root,
                criteriaQuery,
                criteriaBuilder
        ) ->{
            if (firstName == null) {
                return null;
            }
            return criteriaBuilder.like(root.get("firstName"),firstName);
        };
    }
}
