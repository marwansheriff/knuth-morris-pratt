import matplotlib.pyplot as plt

# Example data
sizes = [1000, 10000, 100000, 1000000, 10000000, 100000000]
times = [0.6065, 2.0304 , 10.0007, 12.7338,  39.9726, 357.6481]  # Replace with actual measured times

plt.figure(figsize=(10, 6))
plt.plot(sizes, times, marker='o', color='b', label="Execution Time")
plt.title("KMP Algorithm Performance")
plt.xlabel("Input Size (n)")
plt.ylabel("Execution Time (ms)")
plt.xscale("log")
plt.yscale("log")
plt.grid(True, which="both", linestyle="--", linewidth=0.5)
plt.legend()
plt.show()
