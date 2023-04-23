from machine import Pin


pump = Pin(13, Pin.OUT)
pump.value(1)  # turn on
print("Turn on Delay")

