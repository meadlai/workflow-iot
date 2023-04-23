from machine import Pin


pump = Pin(13, Pin.OUT)
pump.value(0)  # turn off
print("Turn off Delay")

