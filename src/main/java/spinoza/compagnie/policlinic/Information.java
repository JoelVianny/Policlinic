package spinoza.compagnie.policlinic;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Information {

    private final String id;
    private  final String name;

    private final Type  type;

    public  static  enum  Type {
        OPERATION, MEDICINE ,ALLERGY,VITAMIN,SPYCHOLOGICALANTECEDANT

    }
}
