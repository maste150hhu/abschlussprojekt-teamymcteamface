package mops.foren.infrastructure.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "thread")
public class ThreadDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Boolean anonymous;

    private Boolean moderated;

    private Boolean visible;

    @ManyToOne
    private UserDTO author;

    @ManyToOne
    private TopicDTO topic;

    @ManyToOne
    private ForumDTO forum;

    @OneToMany(mappedBy = "thread", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostDTO> posts;

}
