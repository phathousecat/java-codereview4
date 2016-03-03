import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class BandTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void save_savesBandIntoDatabase(){
    Band band = new Band("Modest Mouse");
    band.save();
    assertEquals(Band.all().get(0), band);
  }

  @Test
  public void all_returnsAllBands_emptyAtFirst() {
    assertEquals(Band.all().size(), 0);
  }

  @Test
  public void all_ensuresAllBandsAreSavedCorrectly(){
    Band firstBand = new Band("Modest Mouse");
    Band secondBand = new Band("Beach House");
    firstBand.save();
    secondBand.save();
    assertEquals(Band.all().size(), 2);
  }

}
