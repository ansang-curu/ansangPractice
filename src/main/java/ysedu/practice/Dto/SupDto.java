package ysedu.practice.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import  lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class SupDto {
    private Integer id;
    private String name;
    private String contact1;
    private String contact2;
    private String businessNumber;


}
