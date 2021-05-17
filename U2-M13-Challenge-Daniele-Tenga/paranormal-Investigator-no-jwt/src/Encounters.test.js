import { act, render } from '@testing-library/react';
import Encounters from './Encounters.js';

const data = [
    {
        "id": 1,
        "brief": "Tingling sensation",
        "details": "I swear something is near me. I just know it.",
        "dateTime": "13-May-2021 09:25PM",
        "imageUrl": "https://blogs.bcm.edu/wp-content/uploads/2018/10/ghost-photo.png",
        "investigators": "Tank, Frills"
    },
    {
        "id": 2,
        "brief": "Weird noise",
        "details": "Did you hear that?!",
        "dateTime": "11-May-2021 09:25PM",
        "imageUrl": "https://static.dw.com/image/15815182_303.jpg",
        "investigator": "Koo, Artaern"
    },
    {
        "id": 3,
        "brief": "A foul smell",
        "details": "It smells like a dead person in my room only",
        "dateTime": "09-May-2021 09:25PM",
        "imageUrl": "http://example.com/path/to/an/image.png",
        "investigator": "Monto, Caarew"
    }
];

test("should render 3 encounters", async () => {

    jest.spyOn(global, "fetch").mockImplementation(() =>
        Promise.resolve({
            json: () => Promise.resolve(data)
        }));

    await act(async () => {
        render(<Encounters />);
    });

    const cards = document.querySelectorAll('div[class="card"]');
    expect(cards.length).toBe(3);
});