package co.ke.okworo.schedulingapi.models;

import co.ke.okworo.schedulingapi.db.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    private Status status;
}
