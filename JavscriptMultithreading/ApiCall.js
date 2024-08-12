
const apiUrl = 'https://jsonplaceholder.typicode.com/users';

async function fetchDataAndPerformOperations() {
    try {
        // Fetch data from the API using the fetch function
        const response = await fetch(apiUrl);

        // Check if the request was successful (status code 200)
        if (!response.ok) {
            throw new Error(`Failed to fetch data. Status: ${response.status}`);
        }

        // Parse the response as JSON
        const users = await response.json();
        console.log(typeof users )
        // Process the data (for example, log user names)
        for( let user of users)
        {
            console.log(`User ID: ${user.id}, Name: ${user.name}`);
        }
        // );

        // Perform additional operations as needed

    } catch (error) {
        console.error('Error fetching data:', error.message);
    }
}

// Call the function to initiate the process
fetchDataAndPerformOperations();
