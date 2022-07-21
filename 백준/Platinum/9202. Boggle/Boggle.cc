#include <bits/stdc++.h>
using namespace std;

int w, b;
int cnt, score;
string longest_word;

vector<string> dice;
vector<bool> visited;
vector<pair<int, int> >dir;
struct trie;
trie* p;
bool not_count;

int to_number(char ch)
{
    return (ch - 'A');
}

void score_board(string& word)
{
    if (word.size() == 3 || word.size() == 4)
        score += 1;
    else if (word.size() == 5)
        score += 2;
    else if (word.size() == 6)
        score += 3;
    else if (word.size() == 7)
        score += 5;
    else if (word.size() == 8)
        score += 11;
}
struct trie
{
    vector<trie*>children;
    vector<bool> t_visited;
    bool terminal;
    trie() : terminal(false)
    {
        children.resize(26, nullptr);
        t_visited.resize(30, 0);
    }
    ~trie()
    {
        for (size_t i = 0; i < 26; i++)
            if (children[i])
                delete children[i];
    }

    void insert(string& key, int i)
    {
        if (key[i] == '\0')
            terminal = true;
        else
        {
            int next = to_number(key[i]);
            if (children[next] == nullptr)
                children[next] = new trie();
            children[next]->insert(key, i + 1);
        }
    }

    trie* find(string& key, int i, int& boggle)
    {
        if (key[i] == '\0')
        {
            if ((t_visited[boggle] && terminal) || !terminal)
                not_count = 1;
            else if (terminal)
                t_visited[boggle] = true;
            return (this);
        }
        int next = to_number(key[i]);
        if (children[next] == nullptr)
            return (nullptr);
        return (children[next]->find(key, i + 1, boggle));
    }
};

void input()
{
    int i = -1;

    cin >> w;
    p = new trie();
    while (++i < w)
    {
        string tmp;
        cin >> tmp;
        p->insert(tmp, 0);
    }
    cin >> b;
    dir = { {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1} };
}

void dfs(int i, int j, string word, int& boggle)
{
    if (i < 0 || j < 0 || i >= 4 || j >= 4 || visited[i * 4 + j] || word.size() > 8)
        return;
    word.push_back(dice[i][j]);
    not_count = 0;
    if (p->find(word, 0, boggle) == nullptr)
        return;
    visited[i * 4 + j] = 1;
    if (!not_count)
    {
        if (word.size() > longest_word.size())
        {
            longest_word = "";
            longest_word = word;
        }
        else if (word.size() == longest_word.size())
        {

            if (word.compare(longest_word) < 0)
            {
                longest_word = "";
                longest_word = word;
            }
        }
        cnt++;
        score_board(word);
    }
    for (size_t x = 0; x < 8; x++)
        dfs(i + dir[x].first, j + dir[x].second, word, boggle);
    visited[i * 4 + j] = 0;
}

void solve()
{
    int i;
    string word;

    score = 0;
    cnt = 0;
    i = -1;
    dice = vector<string>(4);
    while (++i < 4)
    {
        dice[i].resize(4);
        cin >> dice[i];
    }
    word = "";
    longest_word = "";
    for (int i = 0; i < 4; i++)
        for (int j = 0; j < 4; j++)
        {
            visited = vector<bool>(16, 0);
            dfs(i, j, word, b);
        }
    cout << score << " " << longest_word << " " << cnt << "\n";
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    input();
    while (b--)
        solve();
    delete (p);
    return (0);
}