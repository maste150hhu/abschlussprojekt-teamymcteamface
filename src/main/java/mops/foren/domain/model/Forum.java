package mops.foren.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Forum {
    private final ForumId id;

    private String title;

    private String description;
}
