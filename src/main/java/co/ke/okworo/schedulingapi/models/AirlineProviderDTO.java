package co.ke.okworo.schedulingapi.models;

import co.ke.okworo.schedulingapi.db.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineProviderDTO {

    private Long id;

    @NotBlank
    private String name;

    private Status status;
}
