import java.math.BigDecimal;
import java.math.BigInteger;

public class Stats {
    public long intCount = 0, floatCount = 0, strCount = 0;
    public BigInteger intSum = BigInteger.ZERO;
    public BigInteger intMin = null, intMax = null;
    public BigDecimal floatSum = BigDecimal.ZERO;
    public BigDecimal floatMin = null, floatMax = null;
    public Integer strMinLen = null, strMaxLen = null;
}
