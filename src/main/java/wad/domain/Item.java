package wad.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @Column (length = 24000)
    private String lead;
    @Column (length = 24000)
    private String text;
    private Integer reads;
    private LocalDateTime time;
    @Column (length = 24000)
    private String image;
    @ManyToMany
    private List<Category> categories;
    @ManyToMany
    private List<Writer> writers;
    
    public ArrayList<String> stringCategories(){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < this.categories.size(); i++){
            list.add(this.categories.get(i).getName());
        }
        return list;
    }
    
    public ArrayList<String> stringWriters(){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < this.writers.size(); i++){
            list.add(this.writers.get(i).getName());
        }
        return list;
    }
}
