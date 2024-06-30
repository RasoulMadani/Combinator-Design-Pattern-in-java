import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "saman",
                "saman@gmail.com",
                "+022222222",
                LocalDate.of(1986, 1, 1)
        );
        CustomerValidationService validationService =
                new CustomerValidationService();
        System.out.println(validationService.isValid(customer));

        CustomerRegistrationValidationService.ValidationResult result =
                CustomerRegistrationValidationService
                    .isEmailValid()
                    .and(
                            CustomerRegistrationValidationService.isAdult()
                    ).and(
                            CustomerRegistrationValidationService.isEmailValid()
                    ).and(
                            CustomerRegistrationValidationService.isPhoneNumberValid()
                    ).apply(customer);
        System.out.println(result);
        if(!result.equals(CustomerRegistrationValidationService.ValidationResult.SUCCESS)){
            throw new IllegalStateException(result.name());
        }
    }
}
