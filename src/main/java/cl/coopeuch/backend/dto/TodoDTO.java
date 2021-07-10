package cl.coopeuch.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Calendar;

@Data
@Builder
public class TodoDTO {
    private Long id;
    private String description;
    private Boolean done;
    private Boolean deleted;
    private Calendar createdTimestamp;
    private Calendar updatedTimestamp;
}
