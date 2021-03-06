package workshop.hello;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityAddTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test public void
    one_plus_one_should_be_two() {
        //Action
        onView(withId(R.id.num1)).perform(typeText("1"));
        onView(withId(R.id.plusBtn)).perform(click());
        onView(withId(R.id.num2)).perform(typeText("1"));
        onView(withId(R.id.calBtn)).perform(click(), closeSoftKeyboard());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("2.00")));
    }

    @Test public void
    one_plus_two_should_be_three() {
        //Action
        onView(withId(R.id.num1)).perform(typeText("1"));
        onView(withId(R.id.plusBtn)).perform(click());
        onView(withId(R.id.num2)).perform(typeText("2"));
        onView(withId(R.id.calBtn)).perform(click(), closeSoftKeyboard());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("3.00")));
    }

}