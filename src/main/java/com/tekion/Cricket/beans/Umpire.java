
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Umpire {
  private String name;
  private String age;
  private long expirience;
  private float correctDecisionProbability;
}
