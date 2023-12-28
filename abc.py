import requests

def get_jira_issues(jira_url, jql_query, username, password):
    """
    Get JIRA issues based on a JQL query.

    :param jira_url: JIRA server URL.
    :param jql_query: JQL query to filter issues.
    :param username: JIRA username.
    :param password: JIRA password.
    :return: List of JIRA issues.
    """
    issues_url = f"{jira_url}/rest/api/2/search"
    headers = {'Content-Type': 'application/json'}
    auth = (username, password)
    params = {'jql': jql_query, 'maxResults': 50}  # You can adjust maxResults based on your needs

    response = requests.get(issues_url, headers=headers, auth=auth, params=params)

    if response.status_code == 200:
        return response.json().get('issues', [])
    else:
        print(f"Error fetching JIRA issues. Status code: {response.status_code}")
        return []

def create_summary(issues):
    """
    Create a summary of JIRA issues.

    :param issues: List of JIRA issues.
    :return: Summary string.
    """
    summary = ""
    for issue in issues:
        key = issue['key']
        summary += f"Issue Key: {key}\n"
        summary += f"Summary: {issue['fields']['summary']}\n"
        summary += f"Description: {issue['fields']['description']}\n"
        summary += "------------------------\n"

    return summary

if __name__ == "__main__":
    # Replace these values with your own JIRA server information and credentials
    JIRA_URL = "https://jira.carbonblack.local"
    JQL_QUERY = "project = 'Your Project' AND issuetype = Story"  # Customize the JQL query
    USERNAME = "jatinp1"
    PASSWORD = "&[l'sui9zAEoY=3"

    issues = get_jira_issues(JIRA_URL, JQL_QUERY, USERNAME, PASSWORD)

    if issues:
        summary = create_summary(issues)
        print(summary)
    else:
        print("No issues found.")
