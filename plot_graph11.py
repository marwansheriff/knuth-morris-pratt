import matplotlib.pyplot as plt
import numpy as np

# Input sizes
sizes = [1000, 10000, 100000, 1000000, 10000000, 100000000]

# Measured execution times (replace with actual data from your program)
execution_times = [0.6065, 2.0304 , 10.0007, 12.7338,  39.9726, 357.6481]  # Example values in milliseconds

# Fixed pattern length (m)
m = 4  # pattern length

# Adjust the scaling factor based on your observations (you might need to tweak this further)
scaling_factor = 1e-3 

# Theoretical O(n + m) complexity (scaled to match measured times)
theoretical_times = [(size + m) * scaling_factor for size in sizes]

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
