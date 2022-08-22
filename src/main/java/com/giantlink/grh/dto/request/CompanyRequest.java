package com.giantlink.grh.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {
    @NotNull(message = "Name is required")
    @Size(min = 3, max = 20)
    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;
    @NotNull
    @NotBlank(message = "Addresse is required")
    private String address;
    @Pattern(regexp = "^[0-9]{10}$",message = "Invalid phone number")
    @NotBlank(message = "Phone number is required")
    private String phone;
    //@Pattern(regexp = "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})\n",message = "Invalid website")
    @NotBlank(message = "Website is required")
    private String website;
    private String description;

}
