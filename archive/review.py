#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import pandas as pd
from pynput import keyboard


DATA_PATH    = "Annotated.csv"
data         = pd.read_csv(DATA_PATH)
stop         = False
idx          = 0
end          = 332


def annotate(val):
    global idx
    print(f'[Annotate {idx} as {val}]')
    data.iloc[idx,6] = val
    idx+=1
    
def save():
    while (True):
        try:
            print("saving..")
            data.to_csv(DATA_PATH, index=False)
            break
        except:
            input("Error saving, try again..")
    
    print("saved")
    
# keyboard event callbacks
def on_release(key):
    global stop, idx
    if key == keyboard.Key.esc:
        stop = True
        return False
    elif key == keyboard.Key.up:
        if (idx > 0):
            idx -= 1
        return False
    elif key  == keyboard.Key.right:
        annotate(1)
        return False
    elif key == keyboard.Key.left:
        annotate(-1)
        return False
    elif key == keyboard.Key.down:
        annotate(0)
        return False

def main():
    while (not stop and idx <= end):
        # maybe save every 5 annotaes, add counter
        print("="*10, idx, "="*10)
        print("[comment]", data.iloc[idx,4])
        print("[rate]",    data.iloc[idx,3])
        print("[predict]", data.iloc[idx,5])
        print(f"[sentiment {data.iloc[idx,6]}]? ")
        # do annotate
        with keyboard.Listener(on_release=on_release) as listener:
            listener.join()
        save()
    print("program ended")
    return

if __name__ == "__main__":
    main()