import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import MyLogin from './MyLogin';

describe('<MyLogin />', () => {
  test('it should mount', () => {
    render(<MyLogin />);
    
    const myLogin = screen.getByTestId('MyLogin');

    expect(myLogin).toBeInTheDocument();
  });
});