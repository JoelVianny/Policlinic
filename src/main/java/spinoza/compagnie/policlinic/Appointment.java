package spinoza.compagnie.policlinic;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Appointment {
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message =  "surname is required ")
    private String surname;
   @NotNull
   @Email
    private String email;
   @Pattern(regexp = "\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$")
    private String telephone;
   @NotNull
    private  String date ;
   @NotNull
    private  String serviceId;
    private String serviceName;
    private Service services;
    @NotNull
    private  String message;
    private  static  enum  Service{

        DIAGNOSTIC,CHIRUGY,PSYCHOLOGICAL
    }


}
