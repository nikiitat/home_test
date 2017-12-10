package qa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by nikitatertytskyi on 01.11.17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserRegistrationTest.class,
        AddNewItemTest.class,
        CountriesSortTest.class
})
public class TestAll {
}
