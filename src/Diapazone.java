/*
  @author   george
  @project   customcollector
  @class  Diapazone
  @version  1.0.0 
  @since 08.10.23 - 10.50
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Diapazone {
    private String name;
    private int from;
    private int to;

    public Diapazone(String name, int from, int to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }
}
