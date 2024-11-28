// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private static final double DEAD_ZONE = 1000;
private final CANSparkMax m_leftfollow = new CANSparkMax(2, MotorType.kBrushed);
private final CANSparkMax m_leftleader = new CANSparkMax(1, MotorType.kBrushed);
private final CANSparkMax m_rightfollow = new CANSparkMax(4, MotorType.kBrushed);
private final CANSparkMax m_rightleader = new CANSparkMax(3, MotorType.kBrushed);
  private final DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftleader, m_rightleader);
double mx;
double my;
public Drivetrain() {
    m_leftfollow.follow(m_leftleader);
     m_rightfollow.follow(m_rightleader);
    m_leftleader.setInverted(true);
    m_leftfollow.setInverted(true);
     m_rightleader.setInverted(false);
    m_rightfollow.setInverted(false);
}
private double applyDeadZone(double input) {
  return Math.abs(input) > DEAD_ZONE ? input : 0.0;
}
public void drive (double x, double y, boolean b) {   
mx = x;
my = y;
x = applyDeadZone(x);
y = applyDeadZone(y);
  }
  @Override
  public final void periodic() {   
m_differentialDrive.arcadeDrive(my, mx);
}
public void arcadeDrive(double d, double e) {

}
public Object drive(double d, double e, double f, boolean b, boolean c) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'drive'");
}

}


