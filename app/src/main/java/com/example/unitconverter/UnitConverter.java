package com.example.unitconverter;

public class UnitConverter {

    public enum Unit {
        INCH,
        CENTIMETER,
        FOOT,
        METER,
        KILOMETER,
        MILE;

        // Helper method to convert text to one of the above constants
        public static Unit fromString(String text) {
            if (text != null) {
                for (Unit unit : Unit.values()) {
                    if (text.equalsIgnoreCase(unit.toString())) {
                        return unit;
                    }
                }
            }

            throw new IllegalArgumentException("Cannot find a value for " + text);
        }
    }

    private final double multiplier;

    public UnitConverter(Unit original, Unit targetUnit) {
        double base = 1;
        // Set the multiplier, else if fromUnit = toUnit, then it is 1
        switch (original) {
            case INCH:
                if (targetUnit == Unit.CENTIMETER) {
                    base = 2.54;
                } else if (targetUnit == Unit.FOOT) {
                    base = 0.0833333;
                } else if (targetUnit == Unit.METER) {
                    base = 0.0254;
                } else if (targetUnit == Unit.MILE) {
                    base = 1.5783e-5;
                } else if (targetUnit == Unit.KILOMETER) {
                    base = 2.54e-5;
                }
                break;
            case CENTIMETER:
                if (targetUnit == Unit.INCH) {
                    base = 0.393701;
                } else if (targetUnit == Unit.FOOT) {
                    base = 0.0328084;
                } else if (targetUnit == Unit.METER) {
                    base = 0.01;
                } else if (targetUnit == Unit.MILE) {
                    base = 6.2137e-6;
                } else if (targetUnit == Unit.KILOMETER) {
                    base = 1e-5;
                }
                break;
            case FOOT:
                if (targetUnit == Unit.INCH) {
                    base = 12;
                } else if (targetUnit == Unit.CENTIMETER) {
                    base = 30.48;
                } else if (targetUnit == Unit.METER) {
                    base = 0.3048;
                } else if (targetUnit == Unit.MILE) {
                    base = 0.000189394;
                } else if (targetUnit == Unit.KILOMETER) {
                    base = 0.0003048;
                }
                break;
            case METER:
                if (targetUnit == Unit.INCH) {
                    base = 39.3701;
                } else if (targetUnit == Unit.CENTIMETER) {
                    base = 100;
                } else if (targetUnit == Unit.FOOT) {
                    base = 3.28084;
                } else if (targetUnit == Unit.MILE) {
                    base = 0.000621371;
                } else if (targetUnit == Unit.KILOMETER) {
                    base = 0.001;
                }
                break;
            case MILE:
                if (targetUnit == Unit.INCH) {
                    base = 63360;
                } else if (targetUnit == Unit.CENTIMETER) {
                    base = 160934;
                } else if (targetUnit == Unit.FOOT) {
                    base = 5280;
                } else if (targetUnit == Unit.METER) {
                    base = 1609.34;
                } else if (targetUnit == Unit.KILOMETER) {
                    base = 1.60934;
                }
                break;
            case KILOMETER:
                if (targetUnit == Unit.INCH) {
                    base = 39370.1;
                } else if (targetUnit == Unit.CENTIMETER) {
                    base = 100000;
                } else if (targetUnit == Unit.FOOT) {
                    base = 3280.84;
                } else if (targetUnit == Unit.METER) {
                    base = 1000;
                } else if (targetUnit == Unit.MILE) {
                    base = 0.621371;
                }
                break;
        }

        multiplier = base;
    }

    public double convert(double input) {
        return input * multiplier;
    }
}