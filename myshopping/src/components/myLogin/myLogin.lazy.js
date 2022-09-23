import React, { lazy, Suspense } from 'react';

const LazyMyLogin = lazy(() => import('./MyLogin'));

const MyLogin = props => (
  <Suspense fallback={null}>
    <LazyMyLogin {...props} />
  </Suspense>
);

export default MyLogin;
