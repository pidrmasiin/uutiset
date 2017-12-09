package wad.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Item extends AbstractPersistable<Long> {

    private String name;
    private String lead;
    private String text;
    private Integer reads;
    private LocalDateTime time;
//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    private byte[] content;
//    @ManyToMany
//    private List<Writer> writers;
//    @ManyToMany
//    private List<Category> categories;

}
