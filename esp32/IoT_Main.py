# 
# 1. Connect WIFI
# 2. Start networking UDP
# 3. Receive data
# 4. Handle data and GPIO
import socket
import time
import network
import machine

# 1. Connect WIFI
def do_connect():
    wlan = network.WLAN(network.STA_IF)
    wlan.active(True)
    if not wlan.isconnected():
        print('connecting to network...')
        # wlan.ifconfig(config=('72.20.10.2', '255.255.255.240', '172.20.10.1', '172.20.10.1'))
        wlan.connect('MDiPhone', 'hangzhou')
        i = 1
        while not wlan.isconnected():
            print("Conecting...{}".format(i))
            i += 1
            time.sleep(1)
    print('Connected network config:', wlan.ifconfig())

# 2. Start the networking: UDP
def start_udp():
    # 2.1. Create UDP socket
    udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    # 2.2. Bind local port
    udp_socket.bind(("0.0.0.0", 7788))
    print('Started networking UDP on 7788')
    return udp_socket

def main():
    # 1. Connect WIFI
    do_connect()
    # 2. Create UDP
    udp_socket = start_udp()
    # 3. Create LED PIN
    led = machine.Pin(2, machine.Pin.OUT)
    pump = machine.Pin(13, machine.Pin.OUT)
    # 4. Receive Data
    while True:
        recv_data, sender_info = udp_socket.recvfrom(1024)
        print("{}Send{}".format(sender_info, recv_data))
        recv_data_str = recv_data.decode("utf-8")
        try:
            print(recv_data_str)
        except Exception as ret:
            print("error:", ret)
        # 5. Handle Data & GPIO
        if recv_data_str == "on":
            print("Light ON...")
            led.value(1)
            pump.value(1)
        elif recv_data_str == "off":
            print("Light OFF...")
            led.value(0)
            pump.value(0)

if __name__ == "__main__":
    main()
