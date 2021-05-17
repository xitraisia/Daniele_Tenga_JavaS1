import { act, render } from '@testing-library/react';
import Investogator from './Investigator.js';

const data = [
    {
        "id": 1,
        "firstName": "Koo",
        "lastName": "Artaern"
    },
    {
        "id": 2,
        "firstName": "Tank",
        "lastName": "Frills"
    },
    {
        "id": 3,
        "firstName": "Monto",
        "lastName": "Caarew"
    }
];

test("should render 3 encounters", async () => {

    jest.spyOn(global, "fetch").mockImplementation(() =>
        Promise.resolve({
            json: () => Promise.resolve(data)
        }));

    await act(async () => {
        render(<Investogator />);
    });

    const cards = document.querySelectorAll('div[class="card"]');
    expect(cards.length).toBe(3);
});