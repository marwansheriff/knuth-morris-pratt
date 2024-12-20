import random
import string
import os

def generate_kmp_dataset(text_size, pattern_size, output_dir, mode="random"):
    """
    Generate a dataset for KMP with text and pattern of specified sizes.
    
    Args:
        text_size (int): Size of the text.
        pattern_size (int): Size of the pattern.
        output_dir (str): Directory to save the dataset file.
        mode (str): Type of dataset. Options: "random", "repetitive", "edge_no_match".
    """
    # Generate text and pattern based on the mode
    if mode == "random":
        text = ''.join(random.choices(string.ascii_lowercase, k=text_size))
        pattern = ''.join(random.choices(string.ascii_lowercase, k=pattern_size))
    elif mode == "repetitive":
        base = "abc"
        text = (base * (text_size // len(base)) + base[:text_size % len(base)])
        pattern = (base * (pattern_size // len(base)) + base[:pattern_size % len(base)])
    elif mode == "edge_no_match":
        text = "a" * text_size  # Text of all 'a'
        pattern = "z" * pattern_size  # Pattern of all 'z'
    else:
        raise ValueError("Invalid mode. Choose from 'random', 'repetitive', or 'edge_no_match'.")

    # Create output directory if it doesn't exist
    os.makedirs(output_dir, exist_ok=True)

    # Write to file
    filename = os.path.join(output_dir, f"dataset_n{text_size}_{mode}.txt")
    with open(filename, "w") as file:
        file.write(f"{text}\n{pattern}\n")
    
    print(f"Dataset created: {filename}")

def main():
    # Define dataset sizes
    dataset_sizes = [1000, 10000, 100000, 1000000, 10000000]  # You can add 100,000,000 if needed
    pattern_size = 100  # Default pattern size
    output_dir = "kmp_datasets"  # Directory to store datasets

    # Generate datasets for each size and mode
    for text_size in dataset_sizes:
        # Generate random dataset
        generate_kmp_dataset(text_size, pattern_size, output_dir, mode="random")
        # Generate repetitive dataset
        generate_kmp_dataset(text_size, pattern_size, output_dir, mode="repetitive")
        # Generate edge case dataset (no matches)
        generate_kmp_dataset(text_size, pattern_size, output_dir, mode="edge_no_match")

if __name__ == "__main__":
    main()
