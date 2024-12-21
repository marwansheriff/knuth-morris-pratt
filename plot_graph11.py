import matplotlib.pyplot as plt
import numpy as np

# Input sizes
sizes = [1000, 10000, 100000, 1000000, 10000000, 100000000]

# Measured execution times (replace with actual data from your program)
execution_times = [0.3245, 1.4 , 9.6, 10.8, 32.6, 305.6]  # Example values in milliseconds

# Fixed pattern length (m)
m = 100  # Example pattern length

# Theoretical O(n + m) complexity (scaled to match measured times)
theoretical_times = [(size + m) * 1e-5 for size in sizes]  # Adjust scaling factor (1e-5)

# Plot measured execution times
plt.figure(figsize=(10, 6))
plt.plot(sizes, execution_times, marker='o', label="Measured Execution Time", color='blue')

# Plot theoretical O(n + m) complexity
plt.plot(sizes, theoretical_times, linestyle='--', label="Theoretical O(n + m) Complexity", color='red')

# Graph labels and settings
plt.title("KMP Algorithm: Measured Execution Time vs Theoretical Complexity")
plt.xlabel("Input Size (n)")
plt.ylabel("Execution Time (ms)")
plt.xscale("log")
plt.yscale("log")
plt.grid(True, which="both", linestyle="--", linewidth=0.5)
plt.legend()

# Show the plot
plt.show()
