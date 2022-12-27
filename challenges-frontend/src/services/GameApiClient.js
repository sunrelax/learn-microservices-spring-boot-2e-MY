class GameApiClient {
    static SERVER_URL = 'http://sunrelax.dnsitalia.org:8000';
    static GET_LEADERBOARD = '/leaders';

    static leaderBoard(): Promise<Response> {
        return fetch(GameApiClient.SERVER_URL +
            GameApiClient.GET_LEADERBOARD);
    }

}

export default GameApiClient;
