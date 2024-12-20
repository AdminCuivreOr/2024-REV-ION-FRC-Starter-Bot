package frc.lib;

import com.revrobotics.SparkPIDController;

public class PIDGains {
  public final double p;
  public final double i;
  public final double d;

  public PIDGains(double _p, double _i, double _d) {
    p = _p;
    i = _i;
    d = _d;
  }

  public static void setSparkGains(SparkPIDController _controller, PIDGains _gains) {
    _controller.setP(_gains.p);
    _controller.setI(_gains.i);
    _controller.setD(_gains.d);
  }
}
