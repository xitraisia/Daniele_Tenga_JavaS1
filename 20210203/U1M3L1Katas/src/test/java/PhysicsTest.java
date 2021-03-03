import com.company.Physics;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class PhysicsTest {
    Physics physics; // declared physics here

    @Before
    public void getStarted(){
        this.physics = new Physics();
    } //I create a new physics here that connects to the physics that was declared above
    @Test
    public void shouldReturnProductOfMassAndAcceleration(){
        assertEquals(6, physics.calculateForce(3.0,2.0),0.00001);
    }
    @Test
    public void shouldReturnTheDistanceMinusDistanceDividedByTimesMinusTimes(){
        assertEquals(1.2,physics.calculateVelocity(4.0,2.0,5.0,3.0),0.00001);
    }
    @Test
    public void shouldReturnWeightDividedByGravity(){
        assertEquals(2,physics.calculateMass(6.0,3.0),0.00001);
    }
    @Test
    public void shouldReturnTheVelocityMinusVelocityDividedByTimesMinusTimes(){
        assertEquals(1,physics.calculateAcceleration(4.0,2.0,5.0,3.0),0.0001);
    }
    @Test
    public void shouldReturnVelocityTimesTime(){
        assertEquals(6, physics.calculateDistance(2.0,3.0),0.00001);
    }
}
